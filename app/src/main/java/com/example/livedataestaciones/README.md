SeasonsDisplayApp

Esta aplicación Android demuestra el uso de LiveData y ViewModel en el patrón de diseño de arquitectura MVVM (Model-View-ViewModel). La aplicación cambia una imagen en la pantalla para representar las cuatro estaciones del año: primavera, verano, otoño e invierno.
Características

    Modelo (SeasonModel): Un modelo que contiene un LiveData que emite un string representando una estación del año cada segundo.
    ViewModel (SeasonViewModel): Un ViewModel que transforma el LiveData<String> del Modelo en un LiveData<Integer>, mapeando cada estación a un recurso de imagen.
    Vista (MainActivity): Una actividad que observa el LiveData<Integer> del ViewModel y actualiza un ImageView con la imagen de la estación correspondiente.

Estructura del Proyecto

    SeasonModel.java: Clase que representa el modelo. Contiene un LiveData<String> que emite una estación del año cada segundo.
    SeasonViewModel.java: Clase ViewModel que transforma los datos del modelo (String de estaciones) en un identificador de imagen (Integer).
    MainActivity.java: Actividad principal que observa el LiveData del ViewModel y actualiza la UI mostrando la imagen correspondiente.
    activity_main.xml: Layout de la actividad principal que contiene un ImageView para mostrar las imágenes de las estaciones.

Cómo Funciona

    Modelo (SeasonModel): Inicia un temporizador que cambia el valor del LiveData<String> cada segundo, rotando entre "primavera", "verano", "otoño" e "invierno".

    ViewModel (SeasonViewModel): Utiliza Transformations.map para convertir el LiveData<String> del modelo en LiveData<Integer>, asignando a cada estación un drawable específico.

    Vista (MainActivity): Observa los cambios en el LiveData<Integer> del ViewModel. Cada vez que el valor cambia, actualiza el ImageView con el recurso de imagen correspondiente a la estación actual.

Recursos y Dependencias

    Android SDK con soporte para LiveData y ViewModel.
    Drawables para cada estación del año (por ejemplo, R.drawable.primavera, R.drawable.verano, etc.)