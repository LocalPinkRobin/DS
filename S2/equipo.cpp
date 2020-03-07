#include "equipo.h"

Equipo::Equipo(Disco* d, Tarjeta* t, Bus* b) {

    disco = new Disco(*d);
    tarjeta = new Tarjeta (*t);
    bus = new Bus (*b);

}

Equipo::~Equipo(){
    delete disco;
    delete tarjeta;
    delete bus;
}

void Equipo::aceptar(VisitanteEquipo *v){
    disco->aceptar(v);
    tarjeta->aceptar(v);
    bus->aceptar(v);
}
