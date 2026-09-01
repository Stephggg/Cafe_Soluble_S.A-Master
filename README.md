# Café Soluble S.A. - Taller #1 Spring Boot

## Especificación técnica de la API

| Operación | Método HTTP | Ruta | Entrada | Respuesta esperada | Código HTTP |
| --- | --- | --- | --- | --- | --- |
| Consultar todos los productos | `GET` | `/api/productos` | No requiere cuerpo. | Colección JSON con todos los productos. | `200 OK` |
| Consultar producto por ID | `GET` | `/api/productos/{id}` | No requiere cuerpo. | Objeto JSON del producto solicitado. | `200 OK` |
| Registrar producto | `POST` | `/api/productos` | JSON con `nombre`, `presentacion`, `categoria` y `disponible`. | Producto creado en JSON con `id` asignado. | `201 Created` |
| Consultar producto inexistente | `GET` | `/api/productos/{id}` | No requiere cuerpo. | Sin contenido porque el recurso no existe. | `404 Not Found` |

### Ejemplo de JSON para registrar

```json
{
  "nombre": "Cafe Arabe",
  "presentacion": "100 g",
  "categoria": "Especialidad",
  "disponible": true
}
```

## Análisis obligatorio

1. La ruta usa un sustantivo porque identifica un recurso (`productos`) y no una acción. La acción la define el método HTTP.
2. Una URI de colección apunta al conjunto completo de recursos. Una URI de recurso individual apunta a un elemento concreto dentro de esa colección.
3. El método HTTP forma parte del significado de la operación porque `GET`, `POST`, `PUT` y `DELETE` expresan la intención sobre la misma ruta.
4. En la URI viaja la identificación del recurso, como el `id`. En JSON viajan los datos del producto, como nombre, presentación, categoría y disponibilidad.
5. `200` indica consulta exitosa, `201` indica creación y `404` indica que el recurso no existe.