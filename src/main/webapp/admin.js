/**
 * 
 */let products = [];
let indexEdit = -1;

const form = document.getElementById("productForm");
const table = document.getElementById("productTable");

form.addEventListener("submit", function (e) {
    e.preventDefault();

    const product = {
        name: name.value,
        price: price.value,
        quantity: quantity.value,
        description: description.value
    };

    if (indexEdit === -1) {
        products.push(product);
    } else {
        products[indexEdit] = product;
        indexEdit = -1;
    }

    form.reset();
    displayProducts();
});

function displayProducts() {
    table.innerHTML = "";

    products.forEach((p, index) => {
        table.innerHTML += `
            <tr>
                <td>${p.name}</td>
                <td>${p.price} DA</td>
                <td>${p.quantity}</td>
                <td>
                    <button class="action-btn edit" onclick="editProduct(${index})">✏️</button>
                    <button class="action-btn delete" onclick="deleteProduct(${index})">🗑</button>
                </td>
            </tr>
        `;
    });
}

function editProduct(index) {
    const p = products[index];
    name.value = p.name;
    price.value = p.price;
    quantity.value = p.quantity;
    description.value = p.description;
    indexEdit = index;
}

function deleteProduct(index) {
    if (confirm("Supprimer ce produit ?")) {
        products.splice(index, 1);
        displayProducts();
    }
	const imageInput = document.getElementById("image");
	const preview = document.getElementById("preview");

	imageInput.addEventListener("change", function () {
	    const file = this.files[0];
	    if (file) {
	        preview.src = URL.createObjectURL(file);
	        preview.style.display = "block";
	    }
	});
}