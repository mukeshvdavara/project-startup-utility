# Android project startup utility

- The page contains bunch of utilities that help when you start new android project.
- You can copy useful code from here.


## Helpful library gradle
  ```
       implementation 'androidx.core:core-ktx:1.8.0'
       implementation 'androidx.appcompat:appcompat:1.4.2'
       implementation 'androidx.viewpager2:viewpager2:1.0.0'
       implementation 'androidx.preference:preference-ktx:1.2.0'
       implementation 'com.google.android.material:material:1.6.1'
       implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    
       implementation 'androidx.activity:activity-ktx:1.5.0'
       implementation 'androidx.fragment:fragment-ktx:1.5.0'
      
       implementation 'androidx.recyclerview:recyclerview:1.2.1'
       implementation 'androidx.recyclerview:recyclerview-selection:1.1.0'
       
       implementation 'androidx.work:work-runtime-ktx:2.7.1'
       implementation 'androidx.work:work-rxjava2:2.7.1'
       
       implementation 'androidx.datastore:datastore-preferences:1.0.0'
       implementation 'androidx.datastore:datastore-preferences-rxjava3:1.0.0'
       
       implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0'
       implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.0'
       implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.0'
       
       implementation 'androidx.navigation:navigation-fragment-ktx:2.5.0'
       implementation 'androidx.navigation:navigation-ui-ktx:2.5.0'
    
       implementation 'androidx.room:room-ktx:2.4.2'
       kapt 'androidx.room:room-compiler:2.4.2'
       implementation 'androidx.room:room-paging:2.4.2'
       implementation 'androidx.room:room-rxjava3:2.4.2'
       
       implementation 'androidx.paging:paging-runtime:3.1.1'
       implementation 'androidx.paging:paging-rxjava3:3.1.1'
    
       kapt 'com.github.bumptech.glide:compiler:4.12.0'
       implementation 'com.github.bumptech.glide:glide:4.13.2'
       
       implementation 'com.squareup.okhttp3:okhttp:4.9.1'
       implementation 'com.squareup.retrofit2:retrofit:2.9.0'
       implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
       
       implementation 'io.reactivex.rxjava3:rxjava:3.1.5'
       implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
           
       implementation 'com.google.dagger:dagger:2.40.5'
       kapt 'com.google.dagger:dagger-compiler:2.40.5'
       
       implementation 'org.jsoup:jsoup:1.14.3'
       implementation 'com.google.code.gson:gson:2.8.9'
       implementation 'com.airbnb.android:lottie:5.2.0'
       implementation 'com.google.guava:guava:31.1-android'
       implementation 'com.jakewharton.timber:timber:5.0.1'
       implementation 'com.google.android.exoplayer:exoplayer:2.18.0'
       implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1'
          
  ```
  
  ## Easy recyclerview adapter
  ##### Copy base adapter class from [here](https://github.com/mukeshvdavara/project-startup-utility/blob/main/BaseAdapter.kt)
  ```
  val adapter: BaseAdapter<YourItemClass> = BaseAdapter.create(this, R.layout.raw_item_grid) { item, holder ->
        val binding = RawItemGridBinding.bind(holder.itemView)
        // do something
  }
