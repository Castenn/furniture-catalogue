<template>
  <div class="cover-container mx-auto text-center flex-column d-flex h-100 w-100">
    <header-view/>
    <router-view/>
    <footer-view/>
  </div>
</template>

<script>

import Header from "./views/Header.vue";
import Footer from "./views/Footer.vue";

export default {
  components: {
    'header-view': Header,
    'footer-view': Footer
  }
}
</script>

<style>
body {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-family: 'Futuris Cyrillic', arial, serif;
}
</style>
