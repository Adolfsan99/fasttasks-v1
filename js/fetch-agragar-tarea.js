const addTaskForm = document.querySelector("#addTask");
        const descripcionInput = document.querySelector("#descripcion");

        addTaskForm.addEventListener("submit", event => {
            event.preventDefault();
            const url = "http://localhost:8080/tareas/crear";
            const data = {
                descripcion: descripcionInput.value
            };
            fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
                .then(response => response.json())
                .then(responseData => {
                    descripcionInput.value = ""; // Limpiar input después de agregar tarea
                    alert(`Tarea agregada con éxito`);
                    location.reload();
                })
                .catch(error => console.log(error));
        });