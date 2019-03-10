// this page is the desired end format for the code output

      wordnice = wordnice.replace(/\[/g, "<tr>");
      wordnice = wordnice.replace(/\\\"/g, "<td>");
      wordnice = wordnice.replace(/\\\",/g, "</td>");
      wordnice = wordnice.replace(/\\\"/g, "</td>");
      wordnice = wordnice.replace(/]]/g, "");
      wordnice = wordnice.replace(/{/g, "<td>");
      wordnice = wordnice.replace(/}/g, "</td></tr>");
      <table>
      <thead>
        <tr>
          <td>Creature Name</td>
          <td>Challenge Rating</td>
          <td>Type</td>
          <td>environment</td>
          <td>alignment</td>
          <td>Combat Role</td>
          <td>environment</td>
          <td>Quantity</td>
        </tr>
      </thead>
      <tbody>
        <tr></tr>
      </tbody>
      
      </table>

