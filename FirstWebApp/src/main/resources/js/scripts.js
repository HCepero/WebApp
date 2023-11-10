// scripts.js
document.addEventListener('DOMContentLoaded', function () {

    // Example function that could be used to toggle the completion status of a to-do item
    const toggleCompletion = (itemId) => {
        // Here you would typically make an AJAX call to your server to update the status of the to-do item
        console.log("Toggle completion for item with ID:", itemId);
        // After successful AJAX call, you can update the class of the item to show completion
        document.getElementById(`item-${itemId}`).classList.toggle('completed');
    };

    // Hook up event listeners to your to-do items (if you have such functionality)
    document.querySelectorAll('.todo-item').forEach(item => {
        item.addEventListener('click', () => toggleCompletion(item.dataset.id));
    });

    // Handle the to-do form submission
    const todoForm = document.getElementById('todo-form');
    if(todoForm) {
        todoForm.addEventListener('submit', function (e) {
            e.preventDefault();
            const description = todoForm.querySelector('input[name="description"]').value;
            // Validate input
            if (description.trim() === '') {
                alert('Please enter a to-do item description.');
                return false;
            }
            // Here you would typically make an AJAX call to your server to add the to-do item
            console.log("Submitting to-do item:", description);
            // Reset the form after submission
            todoForm.reset();
        });
    }
});
