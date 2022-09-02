import os, psutil
import time

def main()->None:

    ruta = 'Archivo\AccidentesDeTransito.csv'
    
    inicio_l = time.time()

    leer(ruta)

    fin_l = time.time()

    print(f"{fin_l - inicio_l} s")
    
    
    #TimerArchivo
    

def leer(ruta: str)->None:

    with open(ruta, 'r', encoding = "utf8") as archivo:

        contador = 1

        for linea in archivo:

            print(f"ESTADO: leyendo registro # {contador}")

            contador += 1

        print("ESTADO: Archivo leido exitosamente")


    #LecturaArchivo

if __name__ == "__main__":
    
    main()
