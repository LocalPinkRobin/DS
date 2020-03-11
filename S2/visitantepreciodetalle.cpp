#include "visitantepreciodetalle.h"

VisitantePrecioDetalle::VisitantePrecioDetalle()
{

}

void VisitantePrecioDetalle::VisitarDisco(Disco * d){
    disco = "Disco: " + to_string(d->getPrecio()) + "€\n";
}

void VisitantePrecioDetalle::VisitarTarjeta(Tarjeta * t){
    tarjeta = "Tarjeta: " + to_string(t->getPrecio()) + "€\n";
}

void VisitantePrecioDetalle::VisitarBus(Bus * b){
    bus = "Bus: " + to_string(b->getPrecio()) + "€";
}

string VisitantePrecioDetalle::getPrecio(){
    return (disco+tarjeta+bus);
}
