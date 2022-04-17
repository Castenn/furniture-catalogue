import axios from "axios";
import ProductList from "../models/ProductList";
import Product from "../models/Product";

const PRODUCTS_PATH = 'http://localhost:8080/api/product/'

class Products {
    getAllProducts(sortDirection, sortField) {
        return axios.get(`${PRODUCTS_PATH}all?sortDirection=${sortDirection}&sortField=${sortField}`)
            .then(response => new ProductList(response.data.map(product => new Product(product))))
    }

    getAllProductsByType(typeId, sortDirection, sortField) {
        return axios.get(`${PRODUCTS_PATH}all?typeId=${typeId}&sortDirection=${sortDirection}&sortField=${sortField}`)
            .then(response => new ProductList(response.data.map(product => new Product(product))))
    }

    getAllProductsByFragment(fragment, sortDirection, sortField) {
        return axios.get(`${PRODUCTS_PATH}all?fragment=${fragment}&sortDirection=${sortDirection}&sortField=${sortField}`)
            .then(response => new ProductList(response.data.map(product => new Product(product))))
    }

    getAllProductsByFragmentAndType(fragment, typeId, sortDirection, sortField) {
        return axios.get(`${PRODUCTS_PATH}all?fragment=${fragment}&typeId=${typeId}&sortDirection=${sortDirection}&sortField=${sortField}`)
            .then(response => new ProductList(response.data.map(product => new Product(product))))
    }

    getProductById(id) {
        return axios.get(`${PRODUCTS_PATH}${id}`)
            .then(response => new Product(response.data))
    }

    saveProduct(product, image) {
        let bodyFormData = new FormData();
        if (product.id) {
            bodyFormData.append('id', product.id);
        }
        bodyFormData.append('article', product.article);
        bodyFormData.append('name', product.name);
        bodyFormData.append('description', product.description);
        bodyFormData.append('price', product.price);
        bodyFormData.append('height', product.height);
        bodyFormData.append('width', product.width);
        bodyFormData.append('depth', product.depth);
        bodyFormData.append('typeId', product.typeId);
        if (image) {
            bodyFormData.append('productImage', image);
        }

        return axios({
            method: 'POST',
            url: `${PRODUCTS_PATH}save`,
            data: bodyFormData,
            config: {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }
        }).then(response => new Product(response.data));
    }

    deleteProduct(id) {
        return axios.delete(`${PRODUCTS_PATH}${id}`);
    }
}

let products = null

export const productsApi = {
    getInstance() {
        if (products == null) {
            products = new Products();
        }
        return products;
    }
}
