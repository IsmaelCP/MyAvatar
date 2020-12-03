package es.studium.myavatar;

public interface OnDialogoListener
{
    // Abrir los Diálogos
    public void abrirDialogoSexo();
    public void abrirDialogoEspecie();
    public void abrirDialogoProfesion();

    // DialogoSexo
    public void onDataSetSexo(String sexo);

    // DiálogoNombre
    public void onDataSetNombre(String nombre);

    // DialogoEspecie
    public void onDataSetEspecie(String especie);

    // DialogoProfesion
    public void onDataSetProfesion(String profesion);

    // Random para obtener los poderes de forma aleatoria
    public void random();

}
