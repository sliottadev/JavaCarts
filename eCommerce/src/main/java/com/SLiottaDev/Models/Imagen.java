package com.SLiottaDev.Models;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table (name="Images")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ImageId" )	
	private Long ImagenId;
	
	@Column(name = "Descripcion" )	
	private String Descripcion;
	
	@Column(name = "FileName" )	
	private String FileName;
	
	@Column(name = "Data" )	
	private byte[] Data;

	public Imagen() {
	}

	public Imagen(Long imagenId, String descripcion, String fileName, byte[] data) {
		ImagenId = imagenId;
		Descripcion = descripcion;
		FileName = fileName;
		Data = data;
	}

	public Long getImagenId() {
		return ImagenId;
	}

	public void setImagenId(Long imagenId) {
		ImagenId = imagenId;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public byte[] getData() {
		return Data;
	}

	public void setData(byte[] data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "Imagen [ImagenId=" + ImagenId + ", Descripcion=" + Descripcion + ", FileName=" + FileName + ", Data="
				+ Arrays.toString(Data) + "]";
	}
	
	

}
