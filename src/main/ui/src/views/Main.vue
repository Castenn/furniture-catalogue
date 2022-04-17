<template>
  <div class="search w-100">
    <p class="text-center fs-1 fw-bold p-3 text-white">Обирайте найкращі пропозиції мебелі!</p>
    <div>
      <input type="search" class="form-control" placeholder="Пошук..." @keyup.enter="searchProducts($event)">
    </div>
  </div>

  <main>
    <div class="sort-filter">
      <div class="sort-filter-types">
        <button class="sort-button"
                v-for="type in types"
                @click="chooseProductsType($event, type)"
                v-bind:class="{ 'active': activeType === type.id }">
          {{ type.name }}
        </button>
      </div>
      <div class="filter-condition">
        <span>Сортування</span>
        <select id="sort-select" @change="changeProductsSort($event)">
          <option value="ASC,name">За назвою А-Я</option>
          <option value="DESC,name">За назвою Я-А</option>
          <option value="ASC,price">За ціною &#9650;</option>
          <option value="DESC,price">За ціною &#9660;</option>
        </select>
      </div>
    </div>

    <div class="products">
      <div class="container">
        <div class="add-product">
          <button id="add-button"><a href="/product/add">Додати позицію</a></button>
        </div>
        <div class="product-items">

          <div class="product" v-for="product in products" @click="redirectToProduct(product.id)">
            <div class="product-content">
              <div class="product-img">
                <img :src="getImagePath(product.image)" alt="product image"/>
              </div>
            </div>

            <div class="product-info">
              <a :href="'/product/show/' + product.id" class="product-name">{{ product.name }}</a>
              <p class="product-price">{{ product.price }} грн</p>
            </div>
          </div>

        </div>
      </div>
    </div>
  </main>
</template>

<script>

import Header from "./Header.vue";
import Footer from "./Footer.vue";
import TypeList from "../models/TypeList";
import ProductList from "../models/ProductList";
import {typesApi} from "../api/types";
import {productsApi} from "../api/products";

export default {
  components: {
    'header-view': Header,
    'footer-view': Footer
  },
  name: "Main",
  data() {
    return {
      types: [],
      products: [],
      activeType: null,
      searchFragment: null,
      sortDirection: 'ASC',
      sortField: 'name',
    }
  },
  async created() {
    this.fetchTypes();
    this.fetchProducts();
  },
  methods: {
    fetchTypes() {
      typesApi.getInstance().getAllTypes()
          .then(types => this.types = types.toArray());
    },
    fetchProducts() {
      if (this.activeType && this.searchFragment) {
        productsApi.getInstance().getAllProductsByFragmentAndType(this.searchFragment, this.activeType, this.sortDirection, this.sortField)
            .then(products => this.products = products.toArray());
      } else if (this.searchFragment) {
        productsApi.getInstance().getAllProductsByFragment(this.searchFragment, this.sortDirection, this.sortField)
            .then(products => this.products = products.toArray());
      } else if (this.activeType) {
        productsApi.getInstance().getAllProductsByType(this.activeType, this.sortDirection, this.sortField)
            .then(products => this.products = products.toArray());
      } else {
        productsApi.getInstance().getAllProducts(this.sortDirection, this.sortField)
            .then(products => this.products = products.toArray());
      }
    },
    getImagePath(image) {
      return `../../../${image.path.substring(14)}/${image.name}.${image.extension}`;
    },
    changeProductsSort(event) {
      const sort = event.target.value.split(',')
      this.sortDirection = sort[0];
      this.sortField = sort[1];
      this.fetchProducts();
    },
    chooseProductsType(event, type) {
      if (event.target.classList.contains('active')) {
        this.activeType = null;
      } else {
        this.activeType = type.id;
      }
      this.fetchProducts();
    },
    searchProducts(event) {
      const fragment = event.target.value;
      if (fragment) {
        this.searchFragment = fragment;
      }
      this.fetchProducts();
      this.searchFragment = null;
      event.target.value = '';
    },
    redirectToProduct(id) {
      this.$router.push('/product/show/' + id);
    }
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
  color: inherit;
}

a:hover {
  color: #546F78;
}

.search {
  height: 500px;
  background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.2)), url(../assets/img/main_bg.jpg) 50%/cover no-repeat;
  background-attachment: fixed;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-control {
  width: 400px;
}

.form-control:focus {
  border-color: #546F78;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(177, 192, 196, 0.7);
}

.sort-filter {
  padding: 10px 10% 10px 10%;
  width: 100%;
  height: auto;
  border-bottom: 1px solid #ededed;
  align-items: center;
  flex-direction: column;
  justify-content: space-between;
}

.sort-filter-types {
}

.sort-filter button.active {
  background: #546F78;
  color: #f8f9fa;
  border-radius: 3px;
}

.sort-button {
  background: none;
  border: none;
  padding: 10px 15px;
  margin: 10px;
  font-size: 1rem;
  color: inherit;
  text-decoration: none;
}

.filter-condition {
  margin: 10px;
  padding: 10px;
  font-size: 1rem;
}

.filter-condition select {
  width: 150px;
  padding: 0 0 0 10px;
  border: none;
  outline: none;
  background: transparent;
  color: #546F78;
  cursor: pointer;
}

img {
  width: 100%;
  display: block;
}

.container {
  width: 88vw;
  margin: 0 auto;
}

.products {
  background: #f8f9fa;
  padding: 1rem 0;
}

.product {
  margin: 2rem;
  position: relative;
}

.product-content {
  background: #ededed;
  cursor: pointer;
}

.product-img {
  background: rgba(255, 255, 255, 0.5);
  box-shadow: 0 0 20px 10px rgba(255, 255, 255, 0.5);
  margin: auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.product-img img {
  transition: transform 0.3s ease;
}

.product:hover .product-img img {
  transform: scale(1.05);
}

.product-info {
  background: white;
  padding: 2rem;
}

.product-name {
  color: black;
  display: block;
  text-decoration: none;
  font-size: 1rem;
  text-transform: uppercase;
  font-weight: bold;
}

.product-name:hover {
  color: #546F78;
}

.product-price {
  display: inline-block;
}

#add-button {
  width: 180px;
  padding: 10px;
  border-radius: 5px;
  border: none;
  transition: 0.5s ease;
  background: #546F78;
  color: #fff;
}

#add-button:hover {
  transform: scale(1.05);
}

#add-button a:hover {
  color: #fff;
}

@media screen and (min-width: 360px) {
  .product-items {
    display: grid;
    grid-template-columns: repeat(1, 1fr);
  }

  .product-img {
    width: 245px;
    height: 245px;
  }
}

@media screen and (min-width: 800px) {
  .product-items {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
  }
}

@media screen and (min-width: 1000px) {
  .product-items {
    grid-template-columns: repeat(3, 1fr);
  }

  .product {
    margin-right: 1rem;
    margin-left: 1rem;
  }
}

@media screen and (min-width: 1250px) {
  .product-items {
    grid-template-columns: repeat(4, 1fr);
  }

  .product-img {
    width: 220px;
    height: 247px;
  }
}
</style>
