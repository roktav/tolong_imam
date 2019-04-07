<template>
	<div id="app">
	<nav-side-bar></nav-side-bar>
	
  	<v-app id="panel" >
  	<h1>Penjadwalan Bulanan Shift Teknisi</h1>
  	<h1> 2 0 1 9 </h1>
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Januari</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
           	
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              	<div>
              	<v-radio-group v-model="column" column>
        			<v-radio label="Option 1" value="radio-1"></v-radio>
       				<v-radio label="Option 2" value="radio-2"></v-radio>
      			</v-radio-group>
              	</div>
              
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Februari</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Maret</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>April</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Mei</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Juni</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Juli</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Agustus</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>September</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Oktober</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>November</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Januari</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
    <v-expansion-panel>
      <v-expansion-panel-content >
        <template v-slot:header>
          <div>
          <h2>Desember</h2>
          </div>
        </template>
        <v-card>
          <v-card-text> 
            <h4> Daftar Teknisi </h4>
            <v-container fluid px-0> 
              <div>
      <v-data-table
        :headers="headers"
        :items="desserts"
      >
        <template v-slot:items="props">
          <td>
            <v-edit-dialog
              :return-value.sync="props.item.nama"
              lazy
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.nama }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.nama"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
          <td class="text-xs-left">{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.alamat }}</td>
          <td class="text-xs-left">{{ props.item.notelp }}</td>
          <td class="text-xs-left">{{ props.item.dokumentasi }}</td>
          <td class="text-xs-left">
            <v-edit-dialog
              :return-value.sync="props.item.shift"
              large
              lazy
              persistent
              @save="save"
              @cancel="cancel"
              @open="open"
              @close="close"
            >
              <div>{{ props.item.shift }}</div>
              <template v-slot:input>
                <div class="mt-3 title">Update Shift</div>
              </template>
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.shift"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                  autofocus
                ></v-text-field>
              </template>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
  
      <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
    </div>
           
            
            </v-container>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
    
    
  </v-app>
</div>
</template>
<script>
import NavSideBar from './NavSideBar';
import Footer from './Footer';
import axios from 'axios';


export default {
  name: 'AdminTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  el: '#app',
  data () {
    return {
      column: null,
  
      snack: false,
      snackColor: '',
      snackText: '',
      max25chars: v => v.length <= 25 || 'Input too long!',
      pagination: {},
      headers: [
        {
          text: 'Nama Teknisi',
          align: 'left',
          sortable: false,
          value: 'nama'
        },
        { text: 'ID Teknisi', value: 'id' },
        { text: 'Alamat', value: 'alamat' },
        { text: 'Nomer Telepon', value: 'notelp' },
        { text: 'Link Foto', value: 'dokumentasi' },
        { text: 'Shift', value: 'shift' }
      ],
      desserts: [
        {
          nama: 'Reihan',
          id : 1,
          alamat : 'Jl Bekasi Raya',
          notelp : '081111111111' ,
          dokumentasi : 'tinyurl.png',
          shift : 'pagi'
        },
        {
          nama: 'Arief',
          id : 2,
          alamat : 'Jl Bogor Raya',
          notelp : '082222222222',
          dokumentasi : 'tinyurl2.png',
          shift : 'siang'
        },
        {
          nama: 'Restow',
          id : 3,
          alamat : 'Jl Padang Raya',
          notelp : '083333333333',
          dokumentasi : 'tinyurl3.png',
          shift : 'pagi'
        }
      ]
    }
  },
  methods: {
    save () {
      this.snack = true
      this.snackColor = 'success'
      this.snackText = 'Data saved'
    },
    cancel () {
      this.snack = true
      this.snackColor = 'error'
      this.snackText = 'Canceled'
    },
    open () {
      this.snack = true
      this.snackColor = 'info'
      this.snackText = 'Dialog opened'
    },
    close () {
      console.log('Dialog closed')
    }
  }
 }

</script>
<style>
#panel {
	margin-left: 270px;
	margin-top: 40px;
	width: 83%;
	
	

}
</style>
