<template>
    <div>
        
    </div>
</template>

<script>
export default {
    async mounted() {
        await this.$store.dispatch('destroyToken')
        this.$router.push({
            name: 'login'
        })
    }    
}
</script>

<style>

</style>
