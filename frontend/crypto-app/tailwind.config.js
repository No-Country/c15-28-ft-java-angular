/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        'custom-primary': "#6157FF",
        'custom-dark-contrast': "#343030",
        'custom-dark-color': "#1E1E1E",
        'custom-primary-gradient-1': "#6157FF",
        'custom-primary-gradient-2': "#EE94FD",
        'custom-text-color': "#C7C6C6",
      },
    },
  },
  plugins: [],
};
