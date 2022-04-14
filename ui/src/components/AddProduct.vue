<template>
  <div class="main-container d-flex h-100 text-center">
    <div class="cover-container d-flex w-100 h-100 mx-auto flex-column">
      <header-view/>

      <main>
        <div class="edit_container">
          <p>Інформація про позицію</p>
          <form>
            <label for="name">Назва:</label>
            <input type="text" name="name" id="name">

            <label for="article">Артикул:</label>
            <input type="number" name="article" id="article">

            <label for="price">Ціна (грн):</label>
            <input type="number" name="price" id="price">

            <label for="desc">Опис:</label>
            <textarea name="desc" id="desc"></textarea>

            <label for="depth">Глибина (см):</label>
            <input type="number" name="depth" id="depth">

            <label for="width">Ширина (cм):</label>
            <input type="number" name="width" id="width">

            <label for="height">Висота (см):</label>
            <input type="number" name="height" id="height">

            <label for="type">Вид товару:</label>
            <select name="type" id="type">
              <option value="Sofa">Дивани</option>
              <option value="saab">Ліжка</option>
              <option value="opel">Крісла</option>
              <option value="audi">Модульні системи</option>
              <option value="audi">Інше</option>
            </select>

            <label for="image">Зображення:</label>
            <input type="file" name="image" id="image">
            <div class="buttons">
              <button id="save">Зберегти зміни</button>
              <button id="delete">Видалити позицію</button>
            </div>
          </form>
        </div>
      </main>

      <footer-view/>
    </div>
  </div>
</template>

<script>
import Header from "./Header.vue";
import Footer from "./Footer.vue";

export default {
  components: {
    'header-view': Header,
    'footer-view': Footer
  },
  name: "AddProduct"
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
