#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

#include <string>
#include "equipo.h"

using namespace std;

class ComponenteEquipo
{
public:
    ComponenteEquipo(int p, string n);
    virtual void aceptar(VisitanteEquipo * v) = 0;
    int getPrecio();
    string getNombre();
private:
    int precio;
    string nombre;

};

#endif // COMPONENTEEQUIPO_H
