package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primTorpedoStore;
  private TorpedoStore secTorpedoStore;

  @BeforeEach
  public void init(){
    primTorpedoStore=mock(TorpedoStore.class);
    secTorpedoStore=mock(TorpedoStore.class);
    this.ship = new GT4500(primTorpedoStore,secTorpedoStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primTorpedoStore.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    
    // Assert
    verify(primTorpedoStore).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primTorpedoStore.fire(1)).thenReturn(true);
    when(secTorpedoStore.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(primTorpedoStore).fire(1);
    verify(secTorpedoStore).fire(1);
    assertEquals(true, result);
  }

}
