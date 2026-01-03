<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="admin.css">
</head>
<body>

<div class="container">
    <h1>🛒 Tableau de bord Admin</h1>

    <form id="productForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/login" method="post">

        <label>Nom du produit</label>
        <input type="text" id="name" required>

        <label>Prix</label>
        <input type="number" id="price" required>

        <label>Quantité</label>
        <input type="number" id="quantity" required>

        <label>Description</label>
        <textarea id="description" required></textarea>

        <!-- Image du produit -->
        <label>Photo du produit</label>
        <input type="file" id="image" accept="image/*">
        <img id="preview" style="display:none; width:120px; margin-top:10px;">

        <button type="submit">💾 Enregistrer</button>
    </form>

    <h2>📦 Liste des produits</h2>
    <table>
        <thead>
            <tr>
                <th>Photo</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody id="productTable"></tbody>
    </table>
</div>

    <script src="admin.js"></script>
</body>
</html>