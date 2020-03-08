#include "disco.h"
#include "visitanteequipo.h"

Disco::Disco(int p, string n):ComponenteEquipo(p,n){

}


void Disco::aceptar(VisitanteEquipo * v){
    v->VisitarDisco(this);
}
