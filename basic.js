function longestString(strings) {
  const maxLength = Math.max(...strings.map(str => str.length));
  return strings.filter(str => str.length === maxLength);
}
