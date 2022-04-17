<template>
  <main class="product-main">
    <div class="product-container">
      <div class="product_content">
        <div class="img-title">
          <div class="desc-img">
            <img :src="getImagePath(this.product.image)" alt="product image">
          </div>
          <div class="product-desc">
            <p id="desc-title">{{ this.product.name }}</p>
            <p id="price">{{ this.product.price }} грн</p>
            <p id="article">Артикул: {{ this.product.article }}</p>
            <div class="edit">
              <button id="edit-button" @click="redirectToEdit()">
                <a :href="'/product/edit/' + this.product.id">Редагувати позицію</a>
              </button>
            </div>
          </div>
        </div>
        <div class="description">
          <p id="desc-text">
            <b>Опис:</b><br>
            <span id="product_desc">{{ this.product.description }}</span>
            <br><b>Глибина (см): </b>
            <span id="depth">{{ this.product.depth }}</span>
            <br><b>Ширина (см): </b>
            <span id="width">{{ this.product.width }}</span>
            <br><b>Висота (см): </b>
            <span id="height">{{ this.product.height }}</span>
            <br><b>Вид товару: </b>
            <span id="type">{{ this.type.name }}</span>
          </p>
        </div>
      </div>
    </div>
  </main>
</template>

<script>

import Product from "../models/Product";
import {productsApi} from "../api/products";
import Type from "../models/Type";
import {typesApi} from "../api/types";

export default {
  name: "ShowProduct",
  data() {
    return {
      id: this.$route.params.productId,
      product: Product,
      type: Type,
    }
  },
  created() {
    this.initProduct(this.id);
  },
  methods: {
    initProduct(id) {
      productsApi.getInstance().getProductById(id)
          .then(product => {
            this.product = product;
            return product.typeId;
          })
          .then(typeId => {
            this.initType(typeId);
          })
    },
    initType(id) {
      typesApi.getInstance().getTypeById(id)
          .then(type => this.type = type);
    },
    getImagePath(image) {
      return `../../../${image.path.substring(14)}/${image.name}.${image.extension}`;
    },
    redirectToEdit() {
      this.$router.push("/product/edit/" + this.id);
    }
  }
}
</script>

<style scoped>
.product-main {
  background-color: #f8f9fa;
}

.product-container {
  width: 70%;
  margin: 0 auto;
  padding: 20px 0;
}

.desc-img {
  width: 60%;
  height: auto;
  margin: 0;
}

.desc-img img {
  width: 100%;
  border-radius: 3px;
  transition: transform 0.3s ease;
}

.desc-img img:hover {
  transform: scale(1.05);
}

.img-title {
  display: flex;
}

.product-desc {
  text-align: left;
  margin-left: 30px;
}

#desc-title {
  font-weight: bold;
  font-size: 1.5rem;
}

#price {
  font-size: 1.3rem;
}

#article {
  color: #546F78;
}

#desc-text {
  margin-top: 30px;
  text-align: left;
}

#edit-button {
  width: 180px;
  padding: 10px;
  border-radius: 5px;
  border: none;
  transition: 0.5s ease;
  background: #546F78;
  color: #fff;
}

#edit-button a {
  text-decoration: none;
  color: inherit;
}

#edit-button:hover {
  transform: scale(1.05);
}

@media screen and (max-width: 1300px) {
  .desc-img {
    width: 70%;
    height: auto;
  }

}

@media screen and (max-width: 1000px) {
  .img-title {
    display: flex;
    flex-direction: column;
  }

  .product-desc {
    margin-left: 0;
    margin-top: 30px;
  }

  .desc-img {
    width: 100%;
    height: auto;
  }
}
</style>
