<template>
  <main>
    <div class="edit_container">
      <p>Інформація про позицію</p>
      <form>
        <label for="name">Назва:</label>
        <input type="text" name="name" id="name" v-model="product.name">

        <label for="article">Артикул:</label>
        <input type="number" name="article" id="article" v-model="product.article">

        <label for="price">Ціна (грн):</label>
        <input type="number" name="price" id="price" v-model="product.price">

        <label for="desc">Опис:</label>
        <textarea name="desc" id="desc" v-model="product.description"/>

        <label for="depth">Глибина (см):</label>
        <input type="number" name="depth" id="depth" v-model="product.depth">

        <label for="width">Ширина (cм):</label>
        <input type="number" name="width" id="width" v-model="product.width">

        <label for="height">Висота (см):</label>
        <input type="number" name="height" id="height" v-model="product.height">

        <label for="type">Вид товару:</label>
        <select name="type" id="type" v-model="product.typeId">
          <option v-for="type in types" :value="type.id">{{ type.name }}</option>
        </select>

        <label for="image">Зображення:</label>
        <input type="file" name="image" id="image" accept="image/*" @change="loadImage($event)">
        <div class="buttons">
          <button type="button" id="save" @click="saveProduct()">Зберегти зміни</button>
        </div>
      </form>
    </div>
  </main>
</template>

<script>
import Type from "../models/Type";
import {productsApi} from "../api/products";
import {typesApi} from "../api/types";

export default {
  name: "AddProduct",
  data() {
    return {
      product: {},
      productImage: null,
      type: Type,
      types: [],
    }
  },
  created() {
    this.fetchTypes();
  },
  methods: {
    fetchTypes() {
      typesApi.getInstance().getAllTypes()
          .then(types => this.types = types.toArray());
    },
    saveProduct() {
      productsApi.getInstance().saveProduct(this.product, this.productImage)
          .then(() => this.$router.push("/"));
    },
    loadImage(event) {
      this.productImage = event.target.files[0];
    },
  }
}
</script>

<style scoped>
.edit_container {
  background: #f8f9fa;
  padding: 30px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;

}

p {
  font-size: 1.3em;
  font-weight: bold;
}

form {
  margin: 0 30px;
  display: flex;
  flex-direction: column;
}

label {
  display: inline-block;
  text-align: left;
  padding: 10px 0 10px 0;
}

input,
textarea,
select {
  width: 500px;
  box-sizing: border-box;
  border: 1px solid #999;
  padding: 5px;
  border-radius: 5px;
  background: #ededed;
}

input:focus, textarea:focus, select:focus {
  outline: none !important;
  border: 1px solid #546F78;
}

textarea {
  vertical-align: top;
  height: 10em;
}

input[type="file"] {
  border: none;
  background: none;
}

button {
  width: 170px;
  padding: 10px;
  margin: 20px 20px 0 0;
  border-radius: 5px;
  border: none;
  transition: 0.5s ease;
}

button:hover {
  transform: scale(1.05);
}

.buttons {
  display: flex;
}

#save {
  background: #546F78;
  color: #fff;
}

#delete {
  background: #78726C;
  color: #fff;
}

@media screen and (max-width: 900px) {
  input,
  textarea,
  select {
    width: 100%;
  }
}

</style>
