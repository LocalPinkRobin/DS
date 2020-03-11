#include <iostream>
#include"equipo.h"
#include "visitanteprecio.h"
#include "visitantepreciodetalle.h"

using namespace std;

int main() {
    Disco *d1,*d2;
    Tarjeta *t1, *t2;
    Bus *b1, *b2;

    d1 = new Disco (100, "hdd");
    d2 = new Disco (200, "ssd");

    t1 = new Tarjeta (500, "amd");
    t2 = new Tarjeta (750, "nvidia");

    b1 = new Bus (3, "bus 1");
    b2 = new Bus (5, "bus 2");

    VisitantePrecio *v1 = new VisitantePrecio;
    VisitantePrecioDetalle *v2 = new VisitantePrecioDetalle;

    Equipo e1(d1, t1, b1);
    Equipo e2 (d2, t2, b2);

    e1.aceptar(v1);
    e1.aceptar(v2);

    cout << "Precio total equipo 1:" << endl;
    cout << v1->getPrecio() << "€" << endl;
    cout << "Precio detallado equipo 1:" << endl;
    cout << v2->getPrecio() << endl;

    e2.aceptar(v1);
    e2.aceptar(v2);

    cout << "Precio total equipo 2:" << endl;
    cout << v1->getPrecio() << "€" << endl;
    cout << "Precio detallado equipo 2:" << endl;
    cout << v2->getPrecio() << endl;


}
