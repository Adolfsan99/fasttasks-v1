document.addEventListener('DOMContentLoaded', function() {
    const url = "http://localhost:8080/tareas/ver";
    fetch(url)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        const datos = data.map(dato => `
          <li class="item">
            ${dato.descripcion}
          </li>
          <button id="editTask" class="editTask" data-id="${dato.id}">✏️</button>
          <button id="delTask" class="delTask" data-id="${dato.id}">❌</button>
        `);
        document.getElementById("tasks").innerHTML = datos;
        
        // Agregar el código para eliminar tarea aquí
  
        const deleteButtons = document.querySelectorAll('.delTask');
    
        if (deleteButtons.length === 0) {
          console.error('Elementos de botón de eliminación no encontrados');
          return;
        }
    
        deleteButtons.forEach(deleteButton => {
          deleteButton.addEventListener('click', function() {
            const id = deleteButton.getAttribute('data-id');
            const url = `http://localhost:8080/tareas/eliminar=${id}`;
    
            fetch(url, { method: 'DELETE' })
              .then(response => {
                if (!response.ok) {
                  throw new Error('Error al eliminar la tarea');
                }
                alert("Has eliminado con exito la tarea!");
                location.reload();
              })
              .catch(error => {
                console.error(error);
              });
          });
        });

        const editButtons = document.querySelectorAll('.editTask');

editButtons.forEach(editButton => {
  editButton.addEventListener('click', function() {
    const id = editButton.getAttribute('data-id');
    const descripcion = prompt('Ingresa la nueva descripción para la tarea:');
    const url = `http://localhost:8080/tareas/editar=${id}`;

    fetch(url, { 
      method: 'post',
      headers:{
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ descripcion })
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Error al editar la tarea');
      }
      alert("Has editado con éxito la tarea!");
      location.reload();
    })
    .catch(error => {
      console.error(error);
    });
  });
});
  
      })
      .catch(error => console.error(error));
  });
  