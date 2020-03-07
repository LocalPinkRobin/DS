#include "tarjeta.h"

Tarjeta::Tarjeta(int p, string n):ComponenteEquipo(p,n){
}

void Tarjeta::aceptar(VisitanteEquipo * v){
    v->VisitarTarjeta(this);
}
