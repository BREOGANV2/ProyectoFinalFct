<?xml version="1.0" encoding="UTF-8"?>
<helpset version="2.0">
    <title>Ayuda - Aplicación de Rutinas</title>

    <maps>
        <homeID>inicio</homeID>
        <mapref location="ayuda.jhm"/>
    </maps>

    <view>
        <name>toc</name>
        <label>Contenido</label>
        <type>javax.help.TOCView</type>
        <data>ayudaTOC.xml</data>
    </view>

    <view>
        <name>index</name>
        <label>Índice</label>
        <type>javax.help.IndexView</type>
        <data>ayudaIndice.xml</data>
    </view>

    <view>
        <name>favoritos</name>
        <label>Favoritos</label>
        <type>javax.help.FavoritesView</type>
    </view>

    <view>
        <name>busqueda</name>
        <label>Búsqueda</label>
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
    </view>

    <presentation default="true" displayviews="true" displayviewimages="true">
        <name>MainHelp</name>
        <size width="800" height="600"/>
        <location x="200" y="150"/>
        <title>Ayuda - Gestión de Usuarios y Rutinas</title>
        <toolbar>
            <helpaction image="BackwardIco">javax.help.BackAction</helpaction>
            <helpaction image="ForwardIco">javax.help.ForwardAction</helpaction>
            <helpaction image="imgAnhadirFavorito">javax.help.FavoritesAction</helpaction>
        </toolbar>
    </presentation>
</helpset>
