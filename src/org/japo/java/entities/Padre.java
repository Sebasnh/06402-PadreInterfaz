/*
 * Copyright 2020 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.util.Objects;
import org.japo.java.interfaces.IPadre;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Padre implements IPadre {

    public static final String DEF_NOMBRE = "Querido Papuchi";

    public static final int MIN_LON = 3;

    private String nombre;

    public Padre() {
        nombre = DEF_NOMBRE;
    }

    public Padre(String nombre) {
        if (validar(nombre)) {
            this.nombre = nombre;

        } else {
            this.nombre = DEF_NOMBRE;

        }

    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (validar(nombre)) {
            this.nombre = nombre;

        }
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Padre)) {
            testOK = false;
        } else {
            testOK = nombre.equals(((Padre) o).getNombre());
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

//    @Override
//   public final String toString() {
//      return String.format("06502-Padre %s", nombre ? "SI" : "NO");
//      
//   }
    @Override
    public final String toString() {
        return String.format("%s - Nombre: %s", getClass().getSimpleName(), nombre);
    }

    private boolean validar(String nombre) {
        return nombre.length() >= MIN_LON && nombre.matches(".*[\\s].*");
    }

    @Override
    public void mostrarNombre() {
        System.out.println(toString());
    }

}
