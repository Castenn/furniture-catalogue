<template>
  <main class="about-main">
    <h1>Переваги нашого каталогу</h1>
    <div class="features">
      <div class="container-about">
        <div class="box">
          <h2>01</h2>
          <h3>Якість</h3>
          <p>
            Всі меблі ми виготовляємо з безпечних матеріалів та комплектуючих. Деталі виготовлені на високоточному
            європейському обладнанні та проходять суворий контроль якості. Меблі сертифіковані та відповідають
            необхідним стандартам.
          </p>
        </div>
        <div class="box">
          <h2>02</h2>
          <h3>Гарантія</h3>
          <p>
            Іноді навіть надійні речі ламаються. Ми створили умови, щоб ви не надто засмутилися з приводу поломки:
            передбачили безліч зручних каналів для оперативного зв'язку з нами та довгий гарантійний термін, протягом
            якого ми полагодимо меблі.
          </p>
        </div>
        <div class="box">
          <h2>03</h2>
          <h3>Політика відкритості</h3>
          <p>
            При великих обсягах виробництва та продажу накладки іноді трапляються, і до клієнта може приїхати
            бракований товар. На відміну від інших меблевих компаній, ми не приховуємо відгуки про такі випадки,
            оскільки хочемо бути чесними зі своїми клієнтами та даємо їм можливість прийняти виважене рішення.
          </p>
        </div>
      </div>
    </div>
    <div class="about-text-container">
      <div class="about-text">
        <p>
          В асортименті компанії меблі для всіх житлових зон - кухні, вітальні, спальні, дитячі та вітальні, а також
          меблі малих форм. Широкий вибір найменувань, яскравий неповторний дизайн, висока якість меблів та її
          функціональність дозволили нашій продукції швидко завоювати свого покупця.
          <br>
          <b>
          Місія компанії – виробництво та організація продажів якісних меблів сучасного дизайну та за
          доступною ціною всім покупцям для всього житлового будинку.
          </b>
          <br>
          Наша компанія, а також наші партнери працюють для того, щоб люди з будь-яким достатком жили комфортно та
          щасливо, і завзято рухаємось до ідеалу – до можливості допомогти у цьому всім мешканцям нашої країни.
          <br>
          Унікальна бізнес-ідея в тому, що купувати товар набагато вигідніше, оскільки жорстко контролюються витрати,
          рівень націнки та підхід до вибору постачальників.
        </p>
      </div>
    </div>
  </main>
</template>

<script>

export default {
  name: "About"
}
</script>

<style scoped>
h1 {
  font-size: 2em;
  margin-top: 30px;
}

.about-main {
  background-color: #f8f9fa;
}

.features {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 60vh;
}

.container-about {
  width: 1100px;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

.container-about .box {
  position: relative;
  width: 320px;
  background: #f8f9fa;
  padding: 50px 40px 30px;
  box-shadow: 0 15px 45px rgba(0, 0, 0, .1);
}

.container-about .box:before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #546F78;
  transform: scaleY(0);
  transform-origin: top;
  transition: transform 0.5s;
}

.container-about .box:hover:before {
  transform: scaleY(1);
  transform-origin: bottom;
  transition: transform 0.5s;
}

.container-about .box h2 {
  position: absolute;
  left: 40px;
  top: 20px;
  font-size: 4em;
  font-weight: 800;
  z-index: 1;
  opacity: 0.1;
  transition: 0.5s;
}

.container-about .box:hover h2 {
  opacity: 1;
  color: #f8f9fa;
  transform: translateY(-40px);
}

.container-about .box h3 {
  position: relative;
  font-size: 1.5em;
  z-index: 2;
  color: #333;
  transition: 0.5s;
}

.container-about .box p {
  position: relative;
  z-index: 2;
  color: #555;
  transition: 0.5s;
}

.container-about .box:hover p,
.container-about .box:hover h3 {
  color: #fff;
}

.about-text-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.about-text {
  width: 1160px;
  margin-top: 30px;
}

p {
  text-align: left;
}

@media screen and (max-width: 1105px) {
  .container-about {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
  }

  .container-about .box {
    margin-top: 30px;
  }
  .about-text {
    width: 80%;
  }
}

@media screen and (min-width: 1005px) {
  .about-text {
    margin-top: 0;
    padding: 30px;
  }
}
</style>
