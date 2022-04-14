<template>
  <div class="main-container d-flex h-100 text-center">
    <div class="cover-container d-flex w-100 h-100 mx-auto flex-column">
      <header-view/>
      <main class="product-main">
        <div class="product-container">
          <div class="product_content">
            <div class="img-title">
              <div class="desc-img">
                <img src="../assets/img/teal-blue-modern-sofa-living-room-furniture.jpg">
              </div>
              <div class="product-desc">
                <p id="desc-title">Диван Benefit 20 / Бенефит 20 Тера Элегант</p>
                <p id="price">15000 грн</p>
                <p id="article">Артикул: 524</p>
                <div class="edit">
                  <button id="edit-button"><a href="edit.html">Редагувати позицію</a></button>
                </div>
              </div>
            </div>
            <div class="description">
              <p id="desc-text">
                <b>Опис:</b><br>
                <span id="product_desc">Красивий сучасний кутовий диван Редкінг Вільям – прикраса будь-якого інтер'єру. Він стильний та практичний, легко розкладається.
                        Модель відмінно підійде для затишних сімейних посиденьок або комфортного відпочинку за читанням улюбленої книги, а вночі стане зручним спальним місцем для кількох людей.
                        Матеріал каркасу та ніжок: натуральне дерево. На ніжках є практичні підкладки з повсті, що запобігає подряпинам на підлозі при переміщенні дивана.
                        Підстава під матрац: пружинна змійка
                        Наповнення м'якої частини: ППУ підвищеної комфортності.
                        Під сидінням є ніша для білизни із білого ламінованого ДСП.</span>
                <br><b>Глибина (см):</b>
                <span id="depth">115</span>
                <br><b>Ширина (см):</b>
                <span id="width">235</span>
                <br><b>Висота (см):</b>
                <span id="height">75</span>
                <br><b>Вид товару:</b>
                <span id="type">Дивани</span>
              </p>
            </div>
          </div>
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
  name: "ShowProduct"
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
