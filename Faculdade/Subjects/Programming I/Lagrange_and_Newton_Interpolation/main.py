import interpolacao as inter, matplotlib.pyplot as plt
from scipy import interpolate

# Função de grau 12:
# f(x) = 3x^12 + 2x^10 - 5x^8 + 7x^6 - x^4 + 4x^2 + 1
grau12 = lambda x: 3*x**12 + 2*x**10 - 5*x**8 + 7*x**6 - x**4 + 4*x**2 + 1

# Função de grau 14:
# f(x) = 4x^14 - 3x^12 + 2x^10 - x^8 + 5x^6 - 4x^4 + 3x^2 - 2
grau14 = lambda x: 4*x**14 - 3*x**12 + 2*x**10 - x**8 + 5*x**6 - 4*x**4 + 3*x**2 - 2

# Função de grau 15:
# f(x) = 5x^15 - 4x^14 + 3x^13 - 2x^12 + x^11 + 7x^10 - 6x^9 + 5x^8 - 4x^7 + 3x^6 - 2x^5 + x^4 + 2x^3 - 3x^2 + 4x - 5
grau15 = lambda x: 5*x**15 - 4*x**14 + 3*x**13 - 2*x**12 + x**11 + 7*x**10 - 6*x**9 + 5*x**8 - 4*x**7 + 3*x**6 - 2*x**5 + x**4 + 2*x**3 - 3*x**2 + 4*x - 5

# Função de grau 16:
# f(x) = x^16 - 3x^15 + 5x^14 - 7x^13 + 9x^12 - 11x^11 + 13x^10 - 15x^9 + 17x^8 - 19x^7 + 21x^6 - 23x^5 + 25x^4 - 27x^3 + 29x^2 - 31x + 33
grau16 = lambda x: x**16 - 3*x**15 + 5*x**14 - 7*x**13 + 9*x**12 - 11*x**11 + 13*x**10 - 15*x**9 + 17*x**8 - 19*x**7 + 21*x**6 - 23*x**5 + 25*x**4 - 27*x**3 + 29*x**2 - 31*x + 33

# Função de grau 17:
# f(x) = -x^17 + 2x^16 - 3x^15 + 4x^14 - 5x^13 + 6x^12 - 7x^11 + 8x^10 - 9x^9 + 10x^8 - 11x^7 + 12x^6 - 13x^5 + 14x^4 - 15x^3 + 16x^2 - 17x + 18
grau17 = lambda x: -x**17 + 2*x**16 - 3*x**15 + 4*x**14 - 5*x**13 + 6*x**12 - 7*x**11 + 8*x**10 - 9*x**9 + 10*x**8 - 11*x**7 + 12*x**6 - 13*x**5 + 14*x**4 - 15*x**3 + 16*x**2 - 17*x + 18


# PEGAR OS PONTOS
#valoresDeX, valoresDeY = inter.gerarPontosAleatorios(grau12, 8)
valoresDeX = [1, 2, 3, 4, 5, 6, 7, 8]
valoresDeY = inter.gerarPontosYPeloX(grau12, valoresDeX)
print(valoresDeX)
print(valoresDeY)

# INTERPOLAÇÃO

#valoresDeX = [[-1, 0, 2], [-1, 0, 1, 2, 3]]
#valoresDeY = [[4, 1, -1], [1, 1, 0, -1, -2]]

x = 1.99999999999999999

Lagrange = inter.Lagrange(valoresDeX, valoresDeY)
y = Lagrange.calcularPolinomioInterpolador(x)
print(y)

Newton = inter.Newton(valoresDeX, valoresDeY)
y = Newton.calcularPolinomiointerpolador(x)
print(y)

Spline = interpolate.splrep(valoresDeX, valoresDeY, k=2)
y = interpolate.splev(x, Spline)
print(y)

pontosAleatoriosX = [1.999999999999999, 3.5, 4.5678, 3.789, 2.99, 7.75254, 6.45, 4.7623, 5.92734, 6.542, 7.23678, 1.1345, 4.1354, 7.265, 5.2534, 3.236, 7.2346, 7.2465654, 2.0000000000001, 4.73216]

# Testes para pontos aleatorios dentro do intervalo tabelado

print("\n")

contador = 1

resultadosOriginais = []
resultadosLagrange = []
resultadosNewton = []

for i in pontosAleatoriosX:
  original = grau12(i)
  lagrange = Lagrange.calcularPolinomioInterpolador(i)
  newton = Newton.calcularPolinomiointerpolador(i)
  resultadosOriginais.append(original)
  resultadosLagrange.append(lagrange)
  resultadosNewton.append(newton)
  
  print(f"{contador} - X: {i}")
  print(f"{contador} - Original: {original}")
  print(f"{contador} - Lagrange: {lagrange}")
  print(f"{contador} - Newton: {newton}\n")
  contador += 1

# EXIBIR GRÁFICAMENTE

# Plot dos pontos tabelados
plt.scatter(valoresDeX, valoresDeY, color='red', label='Pontos Tabelados')

# Plot dos pontos aleatórios
plt.scatter(pontosAleatoriosX, resultadosOriginais, color='blue', label='Pontos Aleatórios')

# Plot dos valores de Newton
plt.scatter(pontosAleatoriosX, resultadosNewton, color='green', label='Valores Newton')

# Plot dos valores de Lagrange
plt.scatter(pontosAleatoriosX, resultadosLagrange, color='yellow', label='Valores Lagrange')

# Plot da função original
x_funcao = [0.01 * i for i in range(850)]  # Pontos para plotar a função original (mais suave)
y_funcao = [grau12(x) for x in x_funcao]
plt.plot(x_funcao, y_funcao, color='black', label='Função Original')

plt.xlabel('x')
plt.ylabel('y')
plt.legend()
plt.title('Comparação da Interpolação com a Função Original')
plt.grid(True)
plt.show()