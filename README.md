# MobileApps Activity 2.1
Actividad 2.1 de la materia de Desarrollo de Aplicaciones para Dispositivos Moviles


# INSTRUCCIONES
Create an app with the following behaviour:
- The app starts and shows a button with the text "LOAD" and an empty recycleview
- When the user presses LOAD the app starts a request to retrieve a JSON from a remote location.
- The JSON must populate the recycleview with one friend per space.
- Each row in the recycle must be a custom layout that includes name of the friend and favorite hobby
- When the user clicks on any element in the list a new view is shown. This view displays text regarding the friend: name, hobby, age,       phone and address.

Things to consider:
- To request remote data use a Thread
- You must create your custom Adapter to load JSON data in the recycle view
