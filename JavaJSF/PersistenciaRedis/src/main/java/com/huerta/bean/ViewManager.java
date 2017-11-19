package com.huerta.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@ManagedBean(name="obj")
@ViewScoped
public class ViewManager implements Serializable{
  private String nombre;
  private String respuesta;
  private Jedis jedis;

  public ViewManager() {
    respuesta = "";
    jedis = new Jedis("localhost");
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
    if(!jedis.sismember("n1:SetClaves",this.nombre)){
     this.respuesta = this.respuesta + " ... te saludo por primera vez";
     jedis.sadd("n1:SetClaves",this.nombre);
     jedis.incr("n1:CuentoClaves:" + this.nombre);
    }
    else {
      jedis.incr("n1:CuentoClaves:" + this.nombre);
      String n1 =jedis.get("n1:CuentoClaves:" + this.nombre);
      this.respuesta=this.respuesta + " ... te he saludado " + n1 +" veces con esta";
    }
    this.nombre="";
    return null;
   }
}
