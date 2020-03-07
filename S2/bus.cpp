#include "bus.h"

Bus::Bus(int p, string n):ComponenteEquipo(p,n){

}

void Bus::aceptar(VisitanteEquipo *v){
    v->VisitarBus(this);
}
