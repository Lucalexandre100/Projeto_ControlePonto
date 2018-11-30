package testes;

import org.junit.*;

import models.Cargo;

public class CargoTest {
	
	@Test
	public void testBuscaPorDesc_Success() {
		Assert.assertEquals(4, Cargo.buscaPorDesc("Animador de festas"));
	}
	
	@Test
	public void testBuscaPorDesc_Failure() {
		Assert.assertEquals(1, Cargo.buscaPorDesc("teste"));
	}
	
	@Test
	public void testBuscaPorDesc_Error() {
		Assert.assertEquals(4, Cargo.buscaPorDesc(null));
	}
}
