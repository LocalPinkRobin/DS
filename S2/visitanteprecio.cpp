#include "visitanteprecio.h"

VisitantePrecio::VisitantePrecio()
{

}

void VisitantePrecio::VisitarDisco(Disco * d){
    precio += d->getPrecio();
}

void VisitantePrecio::VisitarTarjeta(Tarjeta * t){
    precio += t->getPrecio();
}
void VisitantePrecio::VisitarBus(Bus * b){
    precio += b->getPrecio();
}

int VisitantePrecio::getPrecio(){
    return(precio);
}
