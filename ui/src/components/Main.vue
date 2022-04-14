<template>
  <div class="main-container d-flex h-100 text-center">
    <div class="cover-container d-flex w-100 h-100 mx-auto flex-column">
      <header-view/>

      <div class="search w-100">
        <p class="text-center fs-1 fw-bold p-3 text-white">Обирайте найкращі пропозиції мебелі!</p>
        <form>
          <input type="search" class="form-control" placeholder="Пошук...">
        </form>
      </div>

      <main>
        <div class="sort-filter">
          <ul class="indicator">
            <li v-for="type in types">{{ type.name }}</li>
          </ul>
          <div class="filter-condition">
            <span>Сортування</span>
            <select name="" id="select">
              <option value="NameAZ">За назвою А-Я</option>
              <option value="NameZA">За назвою Я-А</option>
              <option value="PriceLowToHigh">За ціною &#9650;</option>
              <option value="PriceHighToLow">За ціною &#9660;</option>
            </select>
          </div>
        </div>
        <div class="products">
          <div class="container">
            <div class="add">
              <button id="add_button"><a href="/product/add">Додати позицію</a></button>
            </div>
            <div class="product-items">

              <!-- single product -->
              <div class="product">
                <div class="product-content">
                  <div class="product-img">
                    <img src="../assets/img/sofa.jpg" alt="product image">
                  </div>
                </div>

                <div class="product-info">
                  <div class="product-info-top">
                    <div class="rating">
                      <span><i class="fas fa-star"></i></span>
                      <span><i class="fas fa-star"></i></span>
                      <span><i class="fas fa-star"></i></span>
                      <span><i class="fas fa-star"></i></span>
                      <span><i class="far fa-star"></i></span>
                    </div>
                  </div>
                  <a href="../assets/img/product.html" class="product-name">М'який диван Sofiia</a>
                  <p class="product-price">7000 грн</p>
                </div>
              </div>
              <!-- end of single product -->

            </div>
          </div>
        </div>
      </main>
      <footer-view/>
    </div>
  </div>
</template>

<script>

import {typesApi} from "../api/types";
import Header from "./Header.vue";
import Footer from "./Footer.vue";

export default {
  components: {
    'header-view': Header,
    'footer-view': Footer
  },
  name: "Main",
  data() {
    return {
      types: Array
    }
  },
  async created() {
    this.types = await typesApi.getInstance().getAllTypes()
  },
}
</script>

<style scoped>
.main-container {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-family: 'Futuris Cyrillic', arial, serif;
}

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
  padding: 35px 15% 20px 15%;
  width: 100%;
  height: 70px;
  border-bottom: 1px solid #ededed;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.sort-filter ul li {
  list-style: none;
  padding: 10px;
  margin: 10px;
  float: left;
  font-size: 1rem;
  border-radius: 3px;
}

.sort-filter ul li.active {
  background: #546F78;
  color: #f8f9fa;
}

.sort-filter ul li a {
  color: inherit;
  text-decoration: none;
}

.filter-condition {
  margin-top: 17px;
  padding: 20px;
  height: 100px;
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
  padding: 1.5rem 0;
}

.product {
  margin: 2rem;
  position: relative;
}

.product-content {
  background: #ededed;
  padding: 1.5rem 0.5rem 0.5rem 0.5rem;
  cursor: pointer;
}

.product-img {
  background: var(rgba(255, 255, 255, 0.5));
  box-shadow: 0 0 20px 10px var(rgba(255, 255, 255, 0.5));
  width: 250px;
  height: 250px;
  margin: 0 auto;
}

.product-info {
  background: white;
  padding: 2rem;
}

.product-info-top {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  padding: 7px;
}

.rating {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.rating span {
  color: #78726C;
  margin: 3px;
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

.product-img img {
  transition: transform 0.3s ease;
}

.product:hover .product-img img {
  transform: scale(1.1);
}

#add_button {
  width: 180px;
  padding: 10px;
  border-radius: 5px;
  border: none;
  transition: 0.5s ease;
  background: #546F78;
  color: #fff;
}

#add_button:hover {
  transform: scale(1.05);
}

#add_button a:hover {
  color: #fff;
}

@media screen and (max-width: 1100px) {
  .sort-filter {
    padding: 0;
    width: 100%;
    height: auto;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: left;

  }

  .sort-filter ul li {
    list-style: none;
    padding: 10px;
    margin: 10px;
    display: flex;
    font-size: 1rem;
  }

  .filter-condition {
    margin-top: 0;
    margin-bottom: 30px;
    padding: 0 0 0 55px;
    height: auto;
    font-size: 1rem;
  }
}

@media screen and (min-width: 992px) {
  .product-items {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
  }

  .sort-filter {
    padding: 35px 7% 20px 7%;
  }
}

@media screen and (min-width: 1200px) {
  .product-items {
    grid-template-columns: repeat(3, 1fr);
  }

  .product {
    margin-right: 1rem;
    margin-left: 1rem;
  }
}

@media screen and (min-width: 1336px) {
  .product-items {
    grid-template-columns: repeat(4, 1fr);
  }
}
</style>
