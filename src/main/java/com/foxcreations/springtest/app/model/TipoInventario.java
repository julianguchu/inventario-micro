package com.foxcreations.springtest.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class TipoInventario {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="tipo_inventario")
		private String descripcionTipo;
		
		

		public TipoInventario() {
			
		}

		public TipoInventario(Integer id, String descripcionTipo) {
			
			this.id = id;
			this.descripcionTipo = descripcionTipo;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDescripcionTipo() {
			return descripcionTipo;
		}

		public void setDescripcionTipo(String descripcionTipo) {
			this.descripcionTipo = descripcionTipo;
		}
		
		
		
}
