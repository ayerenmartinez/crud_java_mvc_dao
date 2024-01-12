
package com.ayeren.crud_mvc_escritorio.dao;

import java.util.List;

/**
 *
 * @author Anthony Davis Yeren Martinez
 */
public interface CRUD<T> {
    List<T> listarTodos();
    T leerPorId(int id);
    void registrar(T t);
    void actualizar(T t);
    void eliminar(int id);
}
