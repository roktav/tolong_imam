<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div id="app">
        <v-app id="inspire">
            <v-layout row wrap>
                <v-flex xs12 sm6 md4>
                    <v-menu
                            v-model="menu2"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="date"
                                    label="Picker without buttons"
                                    prepend-icon="event"
                                    readonly
                                    v-on="on"
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="date" @input="menu2 = false"></v-date-picker>
                    </v-menu>
                </v-flex>
                <v-spacer></v-spacer>
            </v-layout>
        </v-app>
    </div>
</template>

<script>
    export default {
        name: "DatePicker",
        data: () => ({
            date: new Date().toISOString().substr(0, 10),
            menu: false,
            modal: false,
            menu2: false
        })
    }
</script>

<style scoped>

</style>