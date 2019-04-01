<template>
    <mdb-datatable
            :data="data"
            striped
            bordered
    />
</template>

<script>
    import { mdbDatatable } from 'mdbvue';
    export default {
        name: 'DatatablePage',
        components: {
            mdbDatatable
        },
        data() {
            return {
                data: {
                    columns: [
                        {
                            label: 'Kode Produk',
                            field: 'kode',
                            sort: 'asc'
                        },
                        {
                            label: 'Nama Produk',
                            field: 'nama',
                            sort: 'asc'
                        },
                        {
                            label: 'Harga',
                            field: 'harga',
                            sort: 'asc'
                        },
                        {
                            label: 'Status Persediaan',
                            field: 'status',
                            sort: 'asc'
                        },
                    ],
                    rows: [
                        {
                            kode: 'GEDS-85204',
                            nama: '4ch XMEYE 1080N',
                            harga: 'Rp800.000',
                            status: 'Tersedia'
                        },
                        {
                            kode: 'GEDS-85208',
                            nama: '8ch XMEYE 1080N',
                            harga: 'Rp1.000.000',
                            status: 'Tersedia'
                        },
                        {
                            kode: 'GEDS-85210',
                            nama: '8ch XMEYE 1060N',
                            harga: 'Rp1.000.000',
                            status: 'Tersedia'
                        },
                        {
                            kode: 'GEDS-85200',
                            nama: '6ch XMEYE 1080N',
                            harga: 'Rp900.000',
                            status: 'Tersedia'
                        },
                        {
                            kode: 'GEDS-85310',
                            nama: '8ch XMEYE 1020N',
                            harga: 'Rp1.000.000',
                            status: 'Tersedia'
                        },

                    ]
                }
            }
        }
    }
</script>

<style scoped>
    .table-striped tbody tr:nth-of-type(odd) {
        background-color: blue;
    }
</style>