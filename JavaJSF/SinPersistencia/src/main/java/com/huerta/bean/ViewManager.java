package com.huerta.bean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import java.util.HashMap;
import java.util.Map;

@ManagedBean(name="obj")
@ViewScoped
public class ViewManager implements Serializable{
  private String nombre;
  private String respuesta;
  private Set<String> set;   // no lo teníamos
  private Map<String, Integer> freq;  // no lo teníamos

  public ViewManager() {
    respuesta = "";
    set = new HashSet<String>();
    freq = new HashMap<String, Integer>();
  }

  public String getNombre() {
    return nombre;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setRespuesta(String resp) {
    this.respuesta = resp;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String doSomeThing() {
    this.respuesta = "Hola " + this.nombre + " ";
    if(!set.contains(this.nombre)){
     this.respuesta = this.respuesta + " ... te saludo por primera vez";
     set.add(this.nombre);
     //jedis.incr("n1:CuentoClaves:" + this.nombre);
     freq.put(this.nombre, 1);
    }
    else {
      int count = freq.get(this.nombre);
      freq.put(this.nombre, count + 1);
      count++;
      //jedis.incr("n1:CuentoClaves:" + this.nombre);
      //String n1 =jedis.get("n1:CuentoClaves:" + this.nombre);
      this.respuesta=this.respuesta + " ... te he saludado " + count + " veces con esta";
    }
    this.nombre="";
    return null;
   }
}
