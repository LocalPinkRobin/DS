#include "componenteequipo.h"

ComponenteEquipo::ComponenteEquipo(int p, string n){
    precio = p;
    nombre = n;

}

int ComponenteEquipo::getPrecio(){
    return (this->precio);
}

string ComponenteEquipo::getNombre(){
    return(this->nombre);
}
