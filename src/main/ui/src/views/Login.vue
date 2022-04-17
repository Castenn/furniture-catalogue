<template>
  <main class="form-login text-center">
    <form>
      <h1 class="h3 mb-3 fw-normal text-white">Вхід до адмін-панелі</h1>

      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Логін</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Пароль</label>
      </div>
      <button class="w-100 btn btn-lg btn-dark" type="submit">Увійти</button>
    </form>
  </main>
</template>

<script>

export default {
  name: "Login",
}
</script>

<style scoped>
main {
  min-height: 80vh;
  display: flex;
  padding-top: 40px;
  padding-bottom: 40px;
  background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.2)), url(../assets/img/signin_bg.jpg) 50%/cover no-repeat;
}

.form-control:focus {
  border-color: #546F78;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(177, 192, 196, 0.7);
}

.form-login input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-login input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.form-login .form-floating:focus-within {
  z-index: 2;
}

form {
  margin: 7% auto;
  padding: 15px;
  min-width: 330px;
}
</style>
