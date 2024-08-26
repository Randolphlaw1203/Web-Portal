export const ThousandSeparator = (number) => {
  if (number == null) return "";
  return new Intl.NumberFormat().format(number);
};