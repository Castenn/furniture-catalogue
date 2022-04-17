<template>
  <header class="mb-auto p-3">
    <div>
      <h3 class="float-md-start mb-0"><a href="/">Каталог м'яких меблів</a></h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
        <a class="nav-link px-2" aria-current="page" href="/">Головна</a>
        <a class="nav-link px-2" href="/about">Про сайт</a>
        <a class="nav-link px-2" href="#" @click="clickLoginLogout()" v-if="isAuthorized">Вийти</a>
        <a class="nav-link px-2" href="#" @click="clickLoginLogout()" v-else>Увійти</a>
      </nav>
    </div>
  </header>
</template>

<script>

export default {
  name: "Header",
  data() {
    return {
      isAuthorized: false
    }
  },
  created() {
    this.isAuthorized = localStorage.getItem('isAuthorized') === 'true';
  },
  methods: {
    unAuthorize() {
      localStorage.removeItem('isAuthorized');
      this.$router.push('/');
    },
    clickLoginLogout() {
      if (this.isAuthorized) {
        this.unAuthorize();
      } else {
        this.$router.push('/login');
      }
    },
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

.nav-link {
  color: #78726C;
}

.nav-link:hover {
  color: #546F78;
}
</style>
