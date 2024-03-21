import java.util.ArrayList;
import java.util.Date;

public class Finanza {
  private ArrayList<Finanza> gananciaFactura = new ArrayList<>();
  private float gananciaTotal;
  private float gastos;
  private boolean bancarrota;
  private Date periodo;

  public Finanza() {
    this(0, 0, false, null);
  }

  public Finanza(float gananciaTotal, float gastos, boolean bancarrota, Date periodo) {
    this.gananciaTotal = gananciaTotal;
    this.gastos = gastos;
    this.bancarrota = bancarrota;
    this.periodo = periodo;

//Getters y Setters----------------------------------------

  public ArrayList<Finanza> getGananciaFactura() {
  	return gananciaFactura;
  }
  
  public void setGananciaFactura(ArrayList<Finanza> gananciaFactura) {
  	this.gananciaFactura = gananciaFactura;
  }
  
  public float getGananciaTotal() {
  	return gananciaTotal;
  }
  
  public void setGananciaTotal(float gananciaTotal) {
  	this.gananciaTotal = gananciaTotal;
  }
  
  public float getGastos() {
  	return gastos;
  }
  
  public void setGastos(float gastos) {
  	this.gastos = gastos;
  }
  
  public boolean isBancarrota() {
  	return bancarrota;
  }
  
  public void setBancarrota(boolean bancarrota) {
  	this.bancarrota = bancarrota;
  }
  
  public Date getPeriodo() {
  	return periodo;
  }
  
  public void setPeriodo(Date periodo) {
  	this.periodo = periodo;
  }
}