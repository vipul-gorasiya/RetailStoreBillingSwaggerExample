package com.vipul.retailstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vipul.retailstore.invoker.Swagger2SpringBoot;
import com.vipul.retailstore.server.model.Product;
import com.vipul.retailstore.server.model.Product.ProductCategoryEnum;
import com.vipul.retailstore.server.service.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
@WebAppConfiguration
public class ProductResourceTest {
	private MockMvc mockMvc;

	@MockBean
	private StoreService storeService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(storeService.getProduct(Mockito.anyLong())).thenReturn(mockProduct());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Response"+result.getResponse().getContentAsString());

		Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	private Product mockProduct() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Product name");
		product.setProductCategory(ProductCategoryEnum.A);
		product.setCost(20.10);
		return product;
	}
}
