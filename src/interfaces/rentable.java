package interfaces;

public interface rentable{
    void rentcar(int days);
    void returncar();
    double calculaterent(int days);
}